const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "sample.txt")
  .toString()
  .trim()
  .split("\n");

const [n, m, k] = input[0].split(" ").map(Number);
const edges = Array.from({ length: n + 1 }, () => []);

for (let i = 0; i < m; i++) {
  let [s, e, d] = input[1 + i].split(" ").map(Number);
  edges[e].push([s, d]);  // 방향 확인
}

const dist = Array(n + 1).fill(Infinity);
const queue = [];
const arr = input[1 + m].split(" ").map(Number);

for (let k of arr) {
  dist[k] = 0;
  minHeapPush(queue, [0, k]);  // 초기값 추가
}

while (queue.length > 0) {
  let [curDist, curNode] = minHeapPop(queue);

  if (curDist > dist[curNode]) continue;  // 불필요한 연산 제거

  for (let [nextNode, weight] of edges[curNode]) {
    if (dist[nextNode] > curDist + weight) {
      dist[nextNode] = curDist + weight;
      minHeapPush(queue, [dist[nextNode], nextNode]);
    }
  }
}

let answer = -1;
let maxDist = 0;
for (let i = 1; i <= n; i++) {
  if (dist[i] > maxDist) {
    answer = i;
    maxDist = dist[i];
  }
}
console.log(`${answer}\n${maxDist}`);

function minHeapPush(arr, v) {
  arr.push(v);
  let idx = arr.length - 1;
  while (idx > 0) {
    let parent = Math.floor((idx - 1) / 2);
    if (arr[parent][0] <= arr[idx][0]) break;
    [arr[parent], arr[idx]] = [arr[idx], arr[parent]];
    idx = parent;
  }
}

function minHeapPop(arr) {
  if (arr.length === 1) return arr.pop();

  let ret = arr[0];
  arr[0] = arr.pop();

  let idx = 0;
  while (true) {
    let left = idx * 2 + 1;
    let right = idx * 2 + 2;
    let smallest = idx;

    if (left < arr.length && arr[left][0] < arr[smallest][0]) {
      smallest = left;
    }
    if (right < arr.length && arr[right][0] < arr[smallest][0]) {
      smallest = right;
    }

    if (smallest === idx) break;

    [arr[idx], arr[smallest]] = [arr[smallest], arr[idx]];
    idx = smallest;
  }
  return ret;
}