# Workflow: `contributor-codesentinal-contributor-wiki-update.yml`

## Overview
This GitHub Actions workflow is part of the `CodeSentinal` system. Its primary purpose is to automatically trigger a documentation/wiki update for a specific pull request before that PR is merged. This ensures that the repository's wiki or knowledge base remains synchronized with the code changes being proposed.

## Triggers
*   **Manual Trigger (`workflow_dispatch`):** This workflow is designed to be run manually by providing a specific `pr_number` as an input.

## Workflow Logic
1.  **Retrieve PR Metadata:** Uses `actions/github-script` to fetch the source branch and repository information for the provided `pr_number` via the GitHub REST API.
2.  **Checkout Code:** Checks out the identified PR branch to perform the update.
3.  **Execute Update:** Invokes the `samarth96k/CodeSentinal@package-github-action-phase2` action in `wiki-update` mode, utilizing the `GEMINI_API_KEY` secret to process documentation updates.

## Key Permissions
*   `contents: write`: Required to allow the workflow to potentially push documentation updates back to the repository.
*   `pull-requests: write`: Required to retrieve and potentially comment on PR data.

## Risks & Security Considerations
*   **Secret Exposure:** The workflow relies on `GEMINI_API_KEY`. Ensure this secret is stored securely in GitHub Secrets and that the action code is trusted.
*   **Workflow Permissions:** The `contents: write` permission is broad. If compromised, this workflow could be used to modify repository files or history.
*   **Dependency Risks:** The workflow uses a specific version of a third-party action (`samarth96k/CodeSentinal@package-github-action-phase2`). Review updates to this action, as it executes code within the runner environment.

## PR Review Guidelines
When reviewing changes to this file, verify:
1.  **Permission Scope:** Ensure permissions remain at the least privilege required (e.g., avoid elevating to `admin`).
2.  **Input Validation:** Confirm that the `pr_number` input is handled correctly and that no arbitrary command injection is possible through the script steps.
3.  **Action Integrity:** Ensure the `uses` field points to a trusted repository and tag/commit hash. Avoid moving to `latest` or mutable tags if possible to prevent supply chain attacks.
4.  **Security Context:** Verify that the environment variables (like `GEMINI_API_KEY`) are only used in the step that specifically requires them.

---

## CodeSentinal Wiki Update

**Reason:** The workflow input retrieval mechanism was updated to use GitHub event inputs directly, ensuring better compatibility with external workflow triggers.

## Changelog
- **Refactored Input Handling**: Updated the `pr_number` retrieval to use `${{ github.event.inputs.pr_number }}` instead of `core.getInput("pr_number")` to ensure the value is correctly passed when the workflow is triggered via `workflow_dispatch` events.
