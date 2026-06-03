# Repository Memory

This file stores long-term repository knowledge used during CodeSentinal reviews and wiki updates.

## Architectural Decisions

### Memory ID: TEST003

Created At: 2026-06-03T00:00:00.000Z

**Reason**

Review generation and wiki maintenance serve different purposes and should remain isolated.

**Knowledge**

Review mode is responsible for generating GitHub review comments. Wiki-update mode is responsible for maintaining repository knowledge, repository memory, and wiki documentation. The two pipelines should remain independent.

---

## Known Constraints

### Memory ID: TEST005

Created At: 2026-06-03T00:00:00.000Z

**Reason**

GitHub review comments can only be attached to added lines in a pull request diff.

**Knowledge**

CodeSentinal review generation must never create comments targeting removed lines, unchanged lines, or context-only lines. All generated review comments must reference addedLines[].newLine values.

---

## Migration Notes

Document migrations and compatibility concerns.

---

## Review Findings

### Memory ID: TEST004

Created At: 2026-06-03T00:00:00.000Z

**Reason**

Large prompt payloads can exceed Gemini quota and token limits.

**Knowledge**

Global repository context should be sent once and shared across review chunks. Duplicating architecture, review rules, and repository memory for every chunk significantly increases prompt size and may cause quota exhaustion.

---

## Integration Knowledge

### Memory ID: TEST001

Created At: 2026-06-03T00:00:00.000Z

**Reason**

GitHub API operations are vulnerable to transient failures, rate limiting, and network instability.

**Knowledge**

All GitHub API operations including review comment creation, wiki commits, file updates, and pull request interactions should be executed through executeGitHubWithRetry or equivalent retry wrappers.

---

### Memory ID: TEST002

Created At: 2026-06-03T00:00:00.000Z

**Reason**

Review quality depends on repository knowledge and architectural context.

**Knowledge**

Before sending review requests to Gemini, CodeSentinal should load architecture.md, review-rules.md, repository-memory.md, database-schema.md, and any available file-level wiki documents so that review decisions are based on repository-specific knowledge rather than assumptions.

---