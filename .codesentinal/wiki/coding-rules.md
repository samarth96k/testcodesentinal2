# Coding Rules & Review Guidelines

This document outlines the standards for contributing to this repository. All code submissions are expected to adhere to these rules to ensure maintainability, security, and stability.

---

## 1. Security & Workflow Integrity
Our automation strategy relies heavily on GitHub Actions. To maintain the security of our CI/CD pipeline, all contributors must observe the following:

*   **Principle of Least Privilege:** When modifying or adding files to `.github/workflows/`, always define the minimum necessary permissions. Avoid broad `permissions: write-all` settings.
*   **`pull_request_target` Safety:** Be aware that workflows using `pull_request_target` (e.g., `mantainer-codesentinal-fork-review-only.yml`) run in the context of the base repository. **Never** execute code or scripts directly from a PR branch within these workflows if they have elevated permissions.
*   **Workflow Hygiene:**
    *   Avoid using `secrets` in workflows triggered by forks unless strictly necessary and properly scoped.
    *   Ensure all workflow triggers (`on: ...`) are explicit and documented.

## 2. General Coding Standards
*   **Readability:** Code should be self-documenting. Use clear variable and function names.
*   **Consistency:** Follow the existing style conventions within the repository. If modifying an existing file, match its existing indentation and formatting.
*   **Modularity:** Keep functions small and focused on a single responsibility.

## 3. Pull Request (PR) Review Expectations
PRs serve as the primary gateway for changes. Reviewers will check for:

1.  **Scope:** Changes should address a single issue or feature. Avoid "drive-by" refactoring that isn't related to the PR description.
2.  **Automation Compliance:** Any changes to workflow files in `.github/workflows/` will trigger additional scrutiny regarding:
    *   Potential security risks (e.g., injection, unauthorized secret access).
    *   Trigger patterns (e.g., ensuring `debug-pr.yml` is not used in production).
3.  **Documentation:** If a PR introduces new functionality or changes existing workflow logic, the PR must include updated documentation or a brief explanation of the change.

## 4. Repository Workflow Directory
Current managed workflows include:

| Filename | Purpose | Risk Profile |
| :--- | :--- | :--- |
| `contributor-codesentinal-contributor-wiki-update.yml` | Wiki updates for contributors | Low |
| `debud-pr.yml` | Debugging PR-specific issues | Low (Use only for triage) |
| `mantainer-codesentinal-fork-review-only.yml` | Forked PR review automation | **High** (`pull_request_target`) |
| `mantainer-codesentinal-manual-wiki-update.yml` | Manual trigger for wiki updates | Medium |
| `mantainer-codesentinal-same-repo-pr-all.yml` | Internal PR workflow | Low |

---

## 5. Enforcement
*   **Automated Checks:** GitHub Actions will automatically validate the structural integrity of your PR.
*   **Maintainer Review:** No code shall be merged without at least one maintainer review. Maintainers are responsible for verifying the security implications of workflow modifications before approving.

*Failure to comply with these rules may result in the rejection of your PR.*
