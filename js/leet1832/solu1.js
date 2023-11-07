/**
 * @param {string} sentence
 * @return {boolean}
 */
var checkIfPangram = function (sentence) {
  let mySet = new Set();
  for (let i = 0; i < sentence.length; i++) {
    if (sentence[i] >= 'a' && sentence[i] <= 'z') {
      mySet.add(sentence[i]);
      if (mySet.size == 26) {
        return true;
      }
    } else {
      return false;
    }
  }
  return false;
};

let sentence = "thequickbrownfoxjumpsoverthelazydog";
sentence = "leetcode";
let res = checkIfPangram(sentence);
console.log(res);