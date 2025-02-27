function Node(value = -1, prev = null, next = null) {
    this.value = value;
    this.prev = prev;
    this.next = next;
}

function DLL() {
    this.sentinel = new Node(-1);
    this.sentinel.prev = this.sentinel;
    this.sentinel.next = this.sentinel;
    this.size = 0;
}

DLL.prototype.add = function(index, value) {
    if (index < 0 || index > this.size) {
        throw new RangeError("Index out of bounds");
    }

    let current = this.sentinel;
    for (let i = 0; i < index; i++) {
        current = current.next;
    }

    const newNode = new Node(value, current, current.next);
    current.next.prev = newNode;
    current.next = newNode;
    this.size++;
};

DLL.prototype.addFirst = function(value) {
    this.add(0, value);
};

DLL.prototype.addLast = function(value) {
    const newNode = new Node(value, this.sentinel.prev, this.sentinel);
    this.sentinel.prev.next = newNode;
    this.sentinel.prev = newNode;
    this.size++;
};

DLL.prototype.get = function(index) {
    if (index < 0 || index >= this.size) {
        throw new RangeError("Index out of bounds");
    }

    let current = this.sentinel.next;
    for (let i = 0; i < index; i++) {
        current = current.next;
    }

    return current.value;
};

DLL.prototype.getFirst = function() {
    return this.get(0);
};

DLL.prototype.getLast = function() {
    return this.sentinel.prev.value;
};

DLL.prototype.remove = function(index) {
    if (index < 0 || index >= this.size) {
        throw new RangeError("Index out of bounds");
    }

    let current = this.sentinel.next;
    for (let i = 0; i < index; i++) {
        current = current.next;
    }

    current.prev.next = current.next;
    current.next.prev = current.prev;
    this.size--;
    return current.value;
};

DLL.prototype.removeFirst = function() {
    return this.remove(0);
};

DLL.prototype.removeLast = function() {
    current = this.sentinel.prev;
    current.prev.next = this.sentinel;
    this.sentinel.prev = current.prev;
    this.size--;
    return current.value;
};

DLL.prototype.size = function() {
    return this.size;
};

DLL.prototype.isEmpty = function() {
    return this.size === 0;
};

DLL.prototype.indexOf = function(value) {
    let current = this.sentinel.next;
    for (let i = 0; i < this.size; i++) {
        if (current.value === value) {
            return i;
        }
        current = current.next;
    }
    return -1;
};

DLL.prototype.contains = function(value) {
    return this.indexOf(value) !== -1;
};

DLL.prototype.toString = function() {
    let result = "[";
    let current = this.sentinel.next;
    while (current !== this.sentinel) {
        result += current.value;
        if (current.next !== this.sentinel) {
            result += ", ";
        }
        current = current.next;
    }
    result += "]";
    return result;
};

DLL.arrayToDLL = function(arr) {
    const dll = new DLL();
    for (const value of arr) {
        dll.addLast(value);
    }
    return dll;
};

// Example usage
const arr = [1, 2, 3, 4, 5];
const dll = DLL.arrayToDLL(arr);
console.log(dll.toString());

console.log(dll.size());
console.log(dll.isEmpty());

console.log(dll.indexOf(3));
console.log(dll.contains(3));
console.log(dll.indexOf(10));
console.log(dll.contains(10));

dll.add(2, 10);
console.log(dll.toString());

dll.addFirst(20);
console.log(dll.toString());

dll.addLast(30);
console.log(dll.toString());

console.log(dll.get(2));
console.log(dll.getFirst());
console.log(dll.getLast());

console.log(dll.remove(2));
console.log(dll.toString());
console.log(dll.removeFirst());
console.log(dll.toString());
console.log(dll.removeLast());
console.log(dll.toString());