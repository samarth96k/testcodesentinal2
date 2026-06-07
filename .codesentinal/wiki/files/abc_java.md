# Purpose
Acts as a core repository source/configuration file for the CodeSentinal application.

# Responsibilities
Manages repository-level functionality.

# Architectural Role
Serves as an Application Component within the system architecture.

# Critical Review Context
When reviewing changes to this file, the primary focus must be on the correctness of the business logic implemented within.

# Maintenance Notes
Ensure all modifications adhere to the established repository configuration patterns.

# Known Constraints
None identified.

# Related Components
None.

# Repository Memory
- Initialized as a fundamental configuration and source component for the repository.
- Changes require validation against business logic specifications.

---

## Repository Memory Entry

Memory ID: 1a05c5b41acd

Created At: 2026-06-07T08:33:52.726Z

### Reason

File responsibilities evolved to include domain modeling and structured input validation.

### Knowledge

Introduced a static inner 'Product' class for data modeling. Validation logic (ID > 0, price/quantity >= 0) is enforced in the constructor and setters. All user inputs now use 'Integer.parseInt(sc.nextLine())' instead of 'nextInt()' to avoid buffer clearing issues. Future changes should ensure that 'Product' business rules remain encapsulated within the class.

---

## Repository Memory Entry

Memory ID: 68413cf60bc0

Created At: 2026-06-07T08:33:52.727Z

### Reason

Expanded file capabilities and refactored core interaction loop.

### Knowledge

Refactored to include robust `Integer.parseInt(sc.nextLine())` input handling. Added new operations: Search (ID/Name), Low Stock reporting, and Inventory Statistics. Future developers should ensure menu indices and operational logic remain synchronized when adding new features.

---

## Repository Memory Entry

Memory ID: d1e2f892ae67

Created At: 2026-06-07T08:33:52.727Z

### Reason

The main menu switch-case structure was expanded with new functional cases and wrapped in a protective try-catch block to handle input errors gracefully.

### Knowledge

The main interaction loop now includes comprehensive exception handling. Future additions to the menu system must maintain this try-catch structure to ensure the application remains stable during invalid user input.
