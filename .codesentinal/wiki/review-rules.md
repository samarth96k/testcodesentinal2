# CodeSentinal Review Rules

## Overview
CodeSentinal is designed to act as an automated architectural and security reviewer. These rules govern how the system interacts with pull requests to ensure high-quality code integration while minimizing noise.

## Core Directives
1. **Prioritize Correctness:** Verify that logic correctly implements the intended functionality. Identify race conditions, logic errors, or edge-case failures.
2. **Prioritize Security:** Actively scan for insecure GitHub API usage, improper authentication handling, injection vulnerabilities, and exposure of secrets.
3. **Prioritize Architecture:** Ensure changes adhere to the defined roles of the components. Maintain the separation between GitHub API orchestration and Wiki system management.
4. **Zero Tolerance for Style/Formatting:** Do not comment on indentation, spacing, naming conventions, or stylistic choices. If the code is functional and secure, ignore minor stylistic deviations.
5. **Output Format:** All reviews must be returned strictly in **Markdown** format.

## Component-Specific Guidelines

### Infrastructure Adapter: GitHub API Integration
*Applicable to: `codesentinaltest_oct3.yml`, `debud-pr.yml`, `mantainer-codesentinal-fork-review-only.yml`, `mantainer-codesentinal-same-repo-pr-all.yml`, `github_retry_service.php`*

*   **Validation:** Ensure API tokens and permissions are handled according to the principle of least privilege.
*   **Resiliency:** In `github_retry_service.php`, ensure retry logic includes exponential backoff and correct status code handling (rate limits vs. server errors).
*   **Integrity:** Ensure API payloads are constructed safely to prevent injection or malformed request issues.

### Infrastructure Adapter: LLM Wiki System
*Applicable to: `contributor-codesentinal-contributor-wiki-update.yml`, `mantainer-codesentinal-manual-wiki-update.yml`*

*   **Validation:** Ensure write operations to the Wiki are authenticated and limited to authorized scopes.
*   **Consistency:** Ensure automated updates maintain the expected structure of repository knowledge.
*   **Security:** Verify that user-contributed content (via PRs) cannot execute arbitrary commands or manipulate the Wiki system beyond the intended scope.

## Review Workflow
- **Identify:** Determine if the changed file falls under "GitHub API Integration" or "Wiki System" responsibilities.
- **Analyze:** Evaluate the delta against the specific architectural role defined above.
- **Report:** Provide feedback only if there is a substantive risk to correctness, security, or architecture. 
- **Silence:** If no issues regarding correctness, security, or architecture are found, provide a brief confirmation of review completion or remain silent.
