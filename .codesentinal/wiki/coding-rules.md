# Coding Rules & Security Expectations

This document outlines the mandatory coding standards and security practices for contributors to this repository. All Pull Requests (PRs) must adhere to these guidelines to ensure maintainability and security.

---

## 1. GitHub Actions Security Policy
Given that this repository relies heavily on automated workflows for CI/CD and security monitoring, the following rules are mandatory:

### Principle of Least Privilege
*   **Permissions:** All workflows must explicitly define `permissions:` at the job level. Avoid `permissions: write-all`. Grant only the minimum scopes necessary (e.g., `contents: read`).
*   **GHA Token Usage:** Avoid using `GITHUB_TOKEN` for operations that do not require it. 

### Untrusted Code & `pull_request_target`
*   **Risk Mitigation:** The `pull_request_target` trigger runs in the context of the base branch and has access to repository secrets. 
*   **Rule:** Never execute untrusted code (e.g., running `npm install` or executing shell scripts provided by PR authors) inside a `pull_request_target` workflow unless the code is strictly validated or sandboxed.
*   **Review Requirement:** Any change to `.github/workflows/` must undergo a mandatory security review by a maintainer with access to verify that the `pull_request_target` usage is necessary and secure.

---

## 2. Pull Request Workflow
To ensure our automated tooling (`codesentinal`) functions correctly, follow these branching patterns:

*   **Standard PRs:** Use standard feature branches for internal contributors.
*   **Forked PRs:** Be aware that workflows triggered by `pull_request` (as opposed to `pull_request_target`) have limited access to secrets. Ensure your code does not rely on secrets being available in untrusted fork environments.
*   **Workflow Integrity:** Do not introduce new workflows or modify existing ones (e.g., `mantainer-codesentinal-*.yml` or `debud-pr.yml`) without updating the documentation and receiving explicit approval from the repository maintainers.

---

## 3. General Coding Standards

### Code Quality
*   **No "Debug" Code:** Remove all `console.log`, `print`, or debug-specific workflows (like `debud-pr.yml`) before merging. Code intended for debugging should not be committed to the main branch.
*   **Documentation:** All workflows and new scripts must include a header comment explaining their purpose, trigger conditions, and security implications.

### Repository Hygiene
*   **Commit Messages:** Use descriptive, imperative commit messages (e.g., `Add security check to CI pipeline` instead of `fixed stuff`).
*   **Dependency Management:** Ensure that any action used in workflows is pinned to a specific SHA (e.g., `uses: actions/checkout@v4` is okay, but `uses: actions/checkout@sha256:abcdef...` is preferred for high-security workflows).

---

## 4. Security & Compliance Checklist
Before submitting a PR, verify:
- [ ] **Minimal Permissions:** Are `permissions` scoped down to `read` wherever possible?
- [ ] **Trigger Safety:** Is the use of `pull_request_target` verified against the latest security standards?
- [ ] **No Secrets:** Are there any hardcoded credentials in the code or workflow files? (Use GitHub Secrets instead).
- [ ] **CI Passing:** All status checks, specifically those related to `codesentinal`, must pass before a merge is permitted.

---

*Failure to comply with these rules will result in the rejection of your Pull Request. If you have questions regarding the security of a workflow, please open an Issue before submitting a PR.*
