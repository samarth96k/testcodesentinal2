<?php

class GitHubRetryService
{
    private int $maxRetries = 3;

    public function executeWithRetry(callable $operation)
    {
        $attempt = 0;

        while (true) {
            try {
                return $operation();
            } catch (Exception $e) {
                $attempt++;

                if ($attempt >= $this->maxRetries) {
                    throw $e;
                }

                sleep(pow(2, $attempt));
            }
        }
    }

    public function postPullRequestComment(array $comment)
    {
        return $this->executeWithRetry(function () use ($comment) {
            return [
                "success" => true,
                "comment" => $comment
            ];
        });
    }

    public function updateRepositoryWiki(string $content)
    {
        return $this->executeWithRetry(function () use ($content) {
            return [
                "updated" => true,
                "content" => $content
            ];
        });
    }
}