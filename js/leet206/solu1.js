// 使用递归方法逆转链表


// Definition for singly-linked list.
function ListNode(val, next) {
    this.val = (val === undefined ? 0 : val)
    this.next = (next === undefined ? null : next)
}

/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var reverseList = function (head) {
    if (head == null || head.next == null) {
        return head
    }
    let last = reverseList(head.next)
    head.next.next = head
    head.next = null
    return last
};

// 打印链表
let printList = function (head) {
    let pointer = head
    let output = ''
    while (pointer != null) {
        output += pointer.val + ' '
        pointer = pointer.next
    }
    console.log(output);
}

let head = new ListNode(1, null)
head.next = new ListNode(2)
head.next.next = new ListNode(3)
head.next.next.next = new ListNode(4)
head.next.next.next.next = new ListNode(5)
printList(head)
let newHead = reverseList(head)
printList(newHead)


