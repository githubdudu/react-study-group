export class SLLNode {
  constructor(value, next = null) {
    this.value = value;
    this.next = next;
  }

  toString() {
    let current = this;
    const result = [];
    while (current !== null) {
      result.push(current.value);
      current = current.next;
    }
    return result.join(" -> ") + " -> null";
  }
}
/**
 * Combine two single linked lists, append the second list to the end of the first list.
 * This time, you need to consider the case when the list is empty. We use null to
 * represent an empty list.
 *
 * The head1 and head2 are refer to the first node of each list, not the list itself.
 * Helper methods printSLL are provided to print the single linked list.
 *
 * @param {SLLNode} head1 the head of the first single linked list
 * @param {SLLNode} head2 the head of the second single linked list
 * @returns the head of the combined single linked list
 */
const combineTwoSingleLL = (head1, head2) => {
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

  return head1;
};

function createSingleLL123() {
  const n1 = new SLLNode(1);
  const n2 = new SLLNode(2);
  const n3 = new SLLNode(3);
  n1.next = n2;
  n2.next = n3;
  return n1;
}

function createSingleLL456() {
  const n4 = new SLLNode(4);
  const n5 = new SLLNode(5);
  const n6 = new SLLNode(6);
  n4.next = n5;
  n5.next = n6;
  return n4;
}

export function printSLL(head) {
  if (head === null) {
    console.log("null");
    return;
  }

  console.log(head.toString());
}

function test() {
  const head1 = createSingleLL123();
  const head2 = createSingleLL456();
  const head3 = null; // null, an empty list
  const head4 = null; // null, an empty list
  printSLL(head1); // 1 -> 2 -> 3 -> null
  printSLL(head2); // 4 -> 5 -> 6 -> null
  printSLL(head3); // null
  printSLL(head4); // null

  combineTwoSingleLL(head1, head2);
  printSLL(head1); // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
  combineTwoSingleLL(head1, head3);
  printSLL(head1); // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null

  combineTwoSingleLL(head3, head4);
  printSLL(head3); // null

  //   printSLL(result1);
  //   printSLL(result2);
  //   printSLL(result3);
  //   printSLL(result4);

  /**
   * What if we run the following code? What will happen?
   * What the link list will become? What will be printed? WHY?
   *
   */

  /**
   * first list's last node will point to head1 again, which will cause an infinite loop and print RangeError
   */
  combineTwoSingleLL(head1, head1); // 1 -> 2 -> 3 -> 1 -> 2 -> 3 -> null
  printSLL(head1);
}

test();
