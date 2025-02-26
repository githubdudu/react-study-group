import { SLLNode, printSLL } from "./combineTwoSingleLL";

/**
 * Merges two single linked lists into one sorted single linked list.
 * 
 * The head1 and head2 are refer to the first node of each list, not the list itself.
 * Helper methods printSLL are provided to print the single linked list.
 * 
 * Start with the first node of the first list, and then the first node of the second list.
 * Pick up the node from each list in turn, and link the node to the new list. 
 * 
 * If one list is longer than the other, the remaining nodes should be linked to the new list.
 * 
 * For example:
 * 1->2->3->4->5->6->7 ->null
 * 8->9->10->null
 * 
 * result: 1->8->2->9->3->10->4->5->6->7->null
 * 
 * 1->2->3->null
 * 4->5->6->7->8->9->10->null
 * result: 1->4->2->5->3->6->7->8->9->10->null
 * 
 * 1->2->3->null
 * null
 * result: 1->2->3->null
 * 
 * null
 * null
 * result: null
 * @param {SLLNode} head1 the head of the first single linked list
 * @param {SLLNode} head2 the head of the second single linked list
 */
function merge(head1, head2) {
  // TODO
  return null; // change this line
}

printSLL(merge(new SLLNode(1, new SLLNode(2, new SLLNode(3))), new SLLNode(4, new SLLNode(5, new SLLNode(6, new SLLNode(7, new SLLNode(8)))))));

// you may want to add more test cases to test your implementation
