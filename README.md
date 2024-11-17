Tierney Clark ID: 49185051

Muxin Ge ID: 49214496

Program Output:
<img width="1300" alt="Screenshot 2024-11-17 at 5 17 58 PM" src="https://github.com/user-attachments/assets/657a0f65-062b-4238-9424-3220545a02fc">


Performance and Scalability Considerations:

1. Analyze the time complexity of each operation (insert, search) and ensure that they meet the expected performance characteristics of the chosen balanced search tree.

   Time Complexity of insert (put()) and search(get()): The time complexity refers to the number of compares.
   - The red-black BST is black-balanced. The red nodes represent 3 nodes, meaning that they are on the same level, so they are not included in the height. If a root's left child is right with two black leaf nodes, and the root's right child is a black node, the red-black BST is balanced with a height of 1. The number of compares on the left would be 2 and the number of compares on the right would be 1
  ![IMG_4306](https://github.com/user-attachments/assets/01cb5460-6434-4636-b468-5fd6c96b600b)

   -  To acheive the worst case scenario, the function would go through the highest number of compares, which would be one red node for every step down of black nodes to maintain black-balance. Since all paths have the same height, comparing through the highest number of nodes would mean comparing through the pathway with the highest number of red nodes, because they don't influence the height. Then there would be twice the number of compares than a path with all black nodes. Since red nodes lean left, this would mean taking the leftmost path all the way to the minimum node.
![IMG_4307](https://github.com/user-attachments/assets/19d9fc14-1011-43b4-ad26-b0ce8f457802)

- For a red-black BST with N nodes, tracing through a pathway with all black nodes would clearly be log(N). Tracing through the left most path would have a time complexity of 2log(N), since it goes through twice the number of compares, with the red nodes.
  
- Insert takes a node and compares it from the root to find the right place to put it. Search takes a node and compares from the root to find that node in the tree. Insert and search will have the same worst case time complexity of 2log(N) because they perform the same number of compares in tracing along the left most path from the root to the minimum node.

- In the case of this assignment, we found the worst case time complexity by adding a counter to the put() and get() functions that incremented with each recursion/loop. Knowing that the worst case would involve tracing the left most path, we used the min() function to get the minimum node in the tree, which is product id:
0000fe97fd6c7705b08b7f4c7c5312ce
and then deleted the min from the tree so that we could insert it again and search for it to analyze the put() and get() functions. For both put() and get(), the time complexity was 14 for the worst case. But you may have found out that 14 is approiximately equal to log(10003)=13.28 for our BST with 10003 elements rather than 2log(N). This is because our BST does not reflect the theoretically worst-case BST that we described above as having as many red nodes as black-height on the far left path. Our BST is closer to an average case, where the worst case time complexity is closer to log(N). 
<img width="364" alt="Screenshot 2024-11-17 at 4 07 47 PM" src="https://github.com/user-attachments/assets/a8d48b98-f539-477a-9750-0f0441d8a5f2">

2. Implement and analyze the performance of your tree when dealing with a large dataset.

  - The perfomance of the red-black BST is efficient when dealing with a large dataset, because all of its methods are guaranteed to be logarithmic. In comparision to a linked list, suppose we have N elements, the worst-case for search would be that the element we look for is at the end of the list, so we have a time complexity of N as we have to iterate through all the elements. The same applies to insert.
  - As explained the worst case for a red black BST is 2log(N), which is far more efficient than a linked list, especially when N is a very large number. For example, for this data set N = 10003, but 2log(N) = 26.57

3. Discuss how the tree remains balanced after multiple operations and the impact of balancing on performance.

   - For operations that add or remove nodes from the BST, such as insert or delete, the tree needs to regain to perfect balance after making the change. To do this, they use if conditions to check for imbalances, and recursively check and fix these imbalances until the tree is perfectly balanced again.
   - For example, put() has 3 if statements after the recursive calls:
     1) if the right child is red & the left child is black, rotate left. Rotate left means that the right child will become the parent, and the parent will become its red linked left child.
     2) if the left child and its left child are red, rotate right. Rotate right means that the left child will become the parent of its left child and the original parent, which will become the right child.
     3) if both children are red, flip colors. Flip colors means that the two red children switch to black and the parent switches to red.

   - After inserting a new node, put() recursively loops through this process until all of the conditions of perfect balance are satisfied for the entire BST
   - This process adds cost to the insert and delete functions, but for the functions that don't add or remove elements such as get(), it makes the performance far more efficient, because the tree is always perfectly balanced. Search is thus faster in a red-black BST than in elementary BSTs because the tree is balanced. No work for balancing is done during the search functions, and the tree is already balanced so the search time is close to optimal.




