// filepath: /home/linuxdudu/react-study-group/day4/combineTwoDoubleLL.js
class DLLNode {
  constructor(value, next = null, prev = null) {
    this.value = value;
    this.next = next;
    this.prev = prev;
  }

  toString() {
    let current = this;
    const result = [];
    while (current !== null) {
      result.push(current.value);
      current = current.next;
    }
    return result.join(" <-> ") + " <-> null";
  }
}

/**
 * Combine two double linked lists, append the second list to the end of the first list.
 * This time, you need to consider the case when the list is empty. We use null to
 * represent an empty list.
 *
 * The head1 and head2 are refer to the first node of each list, not the list itself.
 * Helper methods printDLL are provided to print the double linked list.
 *
 * @param {DLLNode} head1 the head of the first double linked list
 * @param {DLLNode} head2 the head of the second double linked list
 * @returns the head of the combined double linked list
 */
const combineTwoDoubleLL = (head1, head2) => {
  // TODO
  if (head1 === null) {
    return head2;
  }
  if (head2 === null) {
    return head1;
  }

  let current = head1;
  while (current.next !== null) {
    current = current.next;
  }
  current.next = head2;
  head2.prev = current;

  return head1;
};

function createDoubleLL123() {
  const n1 = new DLLNode(1);
  const n2 = new DLLNode(2);
  const n3 = new DLLNode(3);
  n1.next = n2;
  n2.prev = n1;
  n2.next = n3;
  n3.prev = n2;
  return n1;
}

function createDoubleLL456() {
  const n4 = new DLLNode(4);
  const n5 = new DLLNode(5);
  const n6 = new DLLNode(6);
  n4.next = n5;
  n5.prev = n4;
  n5.next = n6;
  n6.prev = n5;
  return n4;
}

function printDLL(head) {
  if (head === null) {
    console.log("null");
    return;
  }

  console.log(head.toString());
}

function test() {
  const head1 = createDoubleLL123();
  const head2 = createDoubleLL456();
  const head3 = null; // null, an empty list
  const head4 = null; // null, an empty list
  printDLL(head1); // 1 <-> 2 <-> 3 <-> null
  printDLL(head2); // 4 <-> 5 <-> 6 <-> null
  printDLL(head3); // null
  printDLL(head4); // null

  combineTwoDoubleLL(head1, head2);
  printDLL(head1); // 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6 <-> null

  combineTwoDoubleLL(head1, head3);
  printDLL(head1); // 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6 <-> null

  combineTwoDoubleLL(head3, head4);
  printDLL(head3); // null

  // What if we run the following code?
  /**
   * first list's last node will point to head1 again, which will cause an infinite loop and print RangeError
   */
  combineTwoDoubleLL(head1, head1);
  printDLL(head1);
}

test();
