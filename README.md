Tierney Clark ID: 49185051

Muxin Ge ID: 49214496


Performance and Scalability Considerations:

1. Analyze the time complexity of each operation (insert, search) and ensure that they meet the expected performance characteristics of the chosen balanced search tree.

   Time Complexity of insert (put()): The time complexity refers to the number of compares.
   - The red-black BST is black-balanced. The red nodes represent 3 nodes, meaning that they are on the same level, so they are not included in the height. If a root's left child is right with two black leaf nodes, and the root's right child is a black node, the red-black BST is balanced with a height of 1. The number of compares on the left would be 2 and the number of compares on the right would be 1
  ![IMG_4306](https://github.com/user-attachments/assets/01cb5460-6434-4636-b468-5fd6c96b600b)

   - 
   -  To acheive the worst case scenario, the function would go through the highest number of compares, which would be one red node for every step down of black nodes to maintain black-balance. Since all paths have the same height, comparing through the highest number of nodes would mean comparing through the pathway with the highest number of red nodes, because they don't influence the height. Then there would be twice the number of compares than a path with all black nodes. Since red nodes lean left, this would mean taking the leftmost path.
![IMG_4307](https://github.com/user-attachments/assets/19d9fc14-1011-43b4-ad26-b0ce8f457802)
