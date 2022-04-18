Our second use case submisison is "access previous orders." Although it
was orginally designed to be a separate page and interface, our walkthrough
feedback suggested a new approach where the use case is encapsulated into our
previous use case: "Create Issue Ticket." Specifically, previous orders the customer
made are accessed by the dropdown under the "Create Issue Ticket" screen. This allows
the user to associate their complaint with a specific order, which was another piece
of feedback in our walkthrough.

Here is the screen flow to see our use case(s) in action.

1. Login (make sure "customer" is selected and one of the two credential
    options are entered)
       USERNAME    PASSWORD
       =====================
    a. "username", "password"
    b. "mzk123",   "1234"

2. Customer Menu Screen
3. Create Issue Ticket


Beyond this, we also added a new interface, as can be selected in the Customer 
Menu screen: "View Previous Tickets." This allows a customser to see a summary 
of each issue ticket they had previously submitted. This in itself is arguably 
its own use case, although it was not orginally a use case we had designed; but, 
we found it was necessary to compliment the "create issue ticket" use case.


REFACTORING:
1) Deleted large chunks of outdated, commented-out code 
2) Deleted unimplmented and useless functions
3) Replaced concatenation with StringBuilder in toString() functions
   within model classes
4) Deleted outdated, unreachable classes (ImplEditList and RecordSearchUI)
5) Encapsulated switch statment into separate method within Manager classes
   (i.e., utilized the extract refactoring method)
6) Broke UI code into two separate functions within each UI class
    1) Represents the element specifications within the UI
    2) Represents the screen specifications as a whole
7) Changed all UI code to be JPanels with exception of one JFrame class that
   each JPanel uses
8) Cleared out fields in classes that caused unwanted dependencies and could 
   directly conflict with JSON implementation. Replaced fields that referenced 
   other classes with Integer IDs that reference the instance in the other class.
   For example, instead of an IssueOrder referencing an exact instance of a Customer,
   it would have an Integer field that encapsulated the ID of the Customer that placed
   the order.
9) Deviating from our initial plan, fields that were initially planned for deletion
   were kept to allow for flexibility in later implementations.
10) Deleted all traceable code refering to our initial Serializable implementation.
11) Deleted all unused imports.
