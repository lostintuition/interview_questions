#! /usr/bin/env ruby

require_relative "binary_tree"

# The direct implementation of an inorder traversal using recusion has O(h) space complexity, where h is the hight of the tree. Recursion can be removed with an explicit stack, but the space complexity remains O(h)
#
# Write a nonrecursive program for performing inorder traversal on a binary tree. Assume nodes have parent fields.

def in_order_stack(root)
  stack = Array.new
  stack.push(root)
  node = root

  while (!stack.empty?)
    node = stack.last
    while (!node.left.nil?)
      puts "hi"
      stack.push(node.left)
      next
    end
    stack.pop
    puts node
    if (!node.right.nil?)
      stack.push(node.right)
    end
  end
end

b = BinaryTree.new
b.set_up_example_tree

root = b.root

in_order_stack(root)
