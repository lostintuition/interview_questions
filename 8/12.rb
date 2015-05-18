#! /usr/bin/env ruby

require_relative "linked_list"

# Let L be a singly linked list. Assume its nodes are numbered starting at 0.
# Define the even-odd merge of L to be the list consisting of the even-numbered nodes follow by the odd-numbered nodes.
# The even-odd merge is illustrated in Figure 8.10
#
# Write a function that computes the even-odd merge
# [0, 1, 2, 3, 4]

def compute_even_odd_merge(list)
  evens = nil
  odds = nil
  evens = list.head
  if (list.head == nil || list.head.next == nil)
    return evens
  end
  return evens
end

linked_list = LinkedList.create(["0", "1", "2", "3", "4"])

puts compute_even_odd_merge(linked_list)
