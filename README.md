# Contacts
## Contact storing application
### Major features include:
#### Serializtion and Deserilzation of contacts storing object:
  - File name input through first element of command line arguments
#### Support for two types of contacts:
  - Person
  - Organization     
#### Supported actions for contacts include:
  - Adding
  - Deleting
  - Editing
  - Listing
  - Counting
  - Searching

### Code output sample:
```
open contact.db

[menu] Enter action (add, list, search, count, exit): list
1. John Smith
2. Pizza Place
3. Money Bank
4. Jane Doe

[list] Enter action ([number], back): 1
First name: John
Last name: Smith
Birth date: 1-1-81
Gender: M
Number: 555-555-5555
Time created: 2021-09-11T22:56
Time last edit: 2021-09-11T22:56

[record] Enter action (edit, delete, menu): edit
Select a field (first name, last name, birth, gender, number): number
Enter the number: 313-324-5678
Saved
First name: John
Last name: Smith
Birth date: 1-1-81
Gender: M
Number: 313-324-5678
Time created: 2021-09-11T22:56
Time last edit: 2021-09-11T22:58

[record] Enter action (edit, delete, menu): menu

[menu] Enter action (add, list, search, count, exit): add
Enter the type (person, organization): organization
Enter the name: Clothing Store
Enter the address: 776 Shirt Rd.
Enter the number: (123) 456-7894
The record added.

[menu] Enter action (add, list, search, count, exit): list
1. John Smith
2. Pizza Place
3. Money Bank
4. Jane Doe
5. Clothing Store

[list] Enter action ([number], back): 5
Organization name: Clothing Store
Address: 776 Shirt Rd.
Number: (123) 456-7894
Time created: 2021-09-11T23:00
Time last edit: 2021-09-11T23:00

[record] Enter action (edit, delete, menu): menu

[menu] Enter action (add, list, search, count, exit): count
The Phone Book has 5 records.

[menu] Enter action (add, list, search, count, exit): search
Enter search query: Doe
Found 1 results:
1. Jane Doe

[search] Enter action ([number], back, again): again
Enter search query: bank
Found 1 results:
1. Money Bank

[search] Enter action ([number], back, again): 1
Organization name: Money Bank
Address: 64 Pole St.
Number: 222-223-3333
Time created: 2021-09-11T22:57
Time last edit: 2021-09-11T22:57

[record] Enter action (edit, delete, menu): delete
The record deleted!

[menu] Enter action (add, list, search, count, exit): list
1. John Smith
2. Pizza Place
3. Jane Doe
4. Clothing Store

[list] Enter action ([number], back): back

[menu] Enter action (add, list, search, count, exit): exit

Process finished with exit code 0
```
