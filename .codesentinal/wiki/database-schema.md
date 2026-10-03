# Database Schema and Data Contracts

Please provide the content of the "Contract Files" you are referring to. 

Once you provide the source code or definitions (e.g., TypeScript interfaces, JSON schemas, Protobuf files, or DDL scripts), I will generate the `database-schema.md` following your rules:

*   **No inventions:** Only documenting the provided structures.
*   **Focus on Contracts/Interfaces:** Mapping the expected shapes for data exchange.
*   **Focus on Validation/Payloads:** Defining the rules and structures of the data as they exist in your repository.

**Please paste the contract files below.**

---

## Repository Memory Entry

Memory ID: 8ebae09f99f1

Created At: 2026-10-03T08:06:29.744Z

### Reason

The GitHubRetryService defines a standardized output schema for pull request comments and wiki updates, requiring future integrations to follow this structural contract.

### Knowledge

Added GitHubRetryService to manage GitHub interactions. All service methods return a consistent result array containing at least a 'status' field. Future service additions should mirror this response structure to ensure compatibility with existing error handling and reporting logic.
