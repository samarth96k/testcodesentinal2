<?php

class GitHubRetryService
{
    private int $maxAttempts = 4;
    private int $baseDelay = 1;

    public function run(callable $task)
    {
        $attempt = 0;

        do {
            try {
                $attempt++;

                return $task();

            } catch (Exception $error) {

                if ($attempt >= $this->maxAttempts) {
                    throw $error;
                }

                $delay = $this->baseDelay * (2 ** ($attempt - 1));

                sleep($delay);
            }

        } while ($attempt < $this->maxAttempts);
    }

    public function addPullRequestComment(array $comment)
    {
        return $this->run(function () use ($comment) {

            if (empty($comment["body"])) {
                throw new InvalidArgumentException("Comment body cannot be empty.");
            }

            return [
                "status" => "success",
                "type" => "pull_request_comment",
                "data" => $comment
            ];
        });
    }

    public function updateRepositoryWiki(string $content)
    {
        return $this->run(function () use ($content) {

            if (trim($content) === "") {
                throw new InvalidArgumentException("Wiki content cannot be empty.");
            }

            return [
                "status" => "success",
                "type" => "repository_wiki",
                "updated_content" => $content
            ];
        });
    }

    public function createRepositoryIssue(string $title, string $description)
    {
        return $this->run(function () use ($title, $description) {

            if ($title === "") {
                throw new InvalidArgumentException("Issue title is required.");
            }

            return [
                "status" => "created",
                "issue" => [
                    "title" => $title,
                    "description" => $description
                ]
            ];
        });
    }

    public function getRetryConfiguration()
    {
        return [
            "maximum_attempts" => $this->maxAttempts,
            "initial_delay" => $this->baseDelay,
            "strategy" => "exponential_backoff"
        ];
    }
}
