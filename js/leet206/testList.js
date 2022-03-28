var Vehicle = function () {
    this.price = 1000;
};

var v = new Vehicle();
console.log(v.price);

function ListNode(val, next) {
    this.val = (val === undefined ? 0 : val)
    this.next = (next === undefined ? null : next)
}


var node = new ListNode(2, undefined)
node = new ListNode(23, null)
console.log(node.val)
console.log(node.next)