Tierney Clark ID: 49185051

Muxin Ge ID: 49214496


Performance and Scalability Considerations:

1. Analyze the time complexity of each operation (insert, search) and ensure that they meet the expected performance characteristics of the chosen balanced search tree.

   Time Complexity of insert (put()) and search(get()): The time complexity refers to the number of compares.
   - The red-black BST is black-balanced. The red nodes represent 3 nodes, meaning that they are on the same level, so they are not included in the height. If a root's left child is right with two black leaf nodes, and the root's right child is a black node, the red-black BST is balanced with a height of 1. The number of compares on the left would be 2 and the number of compares on the right would be 1
  ![IMG_4306](https://github.com/user-attachments/assets/01cb5460-6434-4636-b468-5fd6c96b600b)

   -  To acheive the worst case scenario, the function would go through the highest number of compares, which would be one red node for every step down of black nodes to maintain black-balance. Since all paths have the same height, comparing through the highest number of nodes would mean comparing through the pathway with the highest number of red nodes, because they don't influence the height. Then there would be twice the number of compares than a path with all black nodes. Since red nodes lean left, this would mean taking the leftmost path all the way to the minimum node.
![IMG_4307](https://github.com/user-attachments/assets/19d9fc14-1011-43b4-ad26-b0ce8f457802)

- For a red-black BST with N nodes, tracing through a pathway with all black nodes would clearly be log(N). Tracing through the left most path would have a time complexity of 2log(N), since it goes through twice the number of compares with the red nodes.
  
- Insert takes a node and compares it from the root to find the right place to put it. Search takes a node and compares from the root to find that node in the tree. Insert and search will have the same worst case time complexity of 2log(N) because they perform the same number of compares in tracing along the left most path from the root to the minimum node.

- In the case of this assignment, we found the worst case time complexity by adding a counter to the put() and get() functions that incremented with each recursion/loop. Knowing that the worst case would involve tracing the left most path, we used the min() function to get the minimum node in the tree, which is product id:
0000fe97fd6c7705b08b7f4c7c5312ce
and then deleted the min from the tree so that we could insert it again and search for it to analyze the put() and get() functions. For both put() and get(), the time complexity was 14 for the worst case.
<img width="364" alt="Screenshot 2024-11-17 at 4 07 47 PM" src="https://github.com/user-attachments/assets/a8d48b98-f539-477a-9750-0f0441d8a5f2">



