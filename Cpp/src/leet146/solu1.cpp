/**
 * head 是比较旧的节点，久未使用；尾部的节点比较活跃，要删除，先从 head 那里开始删除
 */
#include <unordered_map>
#include <string>
#include <vector>
#include <iostream>

struct FanyListNode
{
    int key;
    int value;
    FanyListNode *prev;
    FanyListNode *next;

    FanyListNode()
    {
        prev = nullptr;
        next = nullptr;
    }

    FanyListNode(int k, int v) : key(k), value(v)
    {
        prev = nullptr;
        next = nullptr;
    }
};

class LRUCache
{
  private:
    int capacity;
    std::unordered_map<int, FanyListNode *> hashmap;
    FanyListNode *head;
    FanyListNode *tail;

  public:
    LRUCache(int capacity)
    {
        this->capacity = capacity;
        this->head = new FanyListNode();
        this->tail = new FanyListNode();
        this->head->next = this->tail;
        this->tail->prev = this->head;
    }

    void move_node_to_tail(int key)
    {
        FanyListNode *node = this->hashmap[key];
        node->prev->next = node->next;
        node->next->prev = node->prev;
        this->tail->prev->next = node;
        node->prev = this->tail->prev;
        this->tail->prev = node;
        node->next = this->tail;
    }

    int get(int key)
    {
        if (this->hashmap.count(key))
        {
            this->move_node_to_tail(key);
        }
        return this->hashmap.count(key) ? this->hashmap[key]->value : -1;
    }

    void put(int key, int value)
    {
        if (this->hashmap.count(key))
        {
            this->hashmap[key]->value = value;
            this->move_node_to_tail(key);
        }
        else
        {
            if (this->capacity == this->hashmap.size())
            {
                this->hashmap.erase(this->head->next->key);
                FanyListNode *first_node = this->head->next;
                this->head->next = this->head->next->next;
                this->head->next->prev = this->head;
                delete first_node; // to avoid memory leak
            }
            FanyListNode *new_node = new FanyListNode(key, value);
            this->hashmap[key] = new_node;
            new_node->prev = this->tail->prev;
            this->tail->prev->next = new_node;
            this->tail->prev = new_node;
            new_node->next = this->tail;
        }
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */

int main(int argc, char *argv[])
{
    // case1
    // expected: [null, null, null, 1, null, -1, null, -1, 3, 4]
    std::vector<std::string> actions = {"LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"};
    std::vector<std::vector<int>> data = {{2}, {1, 1}, {2, 2}, {1}, {3, 3}, {2}, {4, 4}, {1}, {3}, {4}};

    // case2
    // expected: [null, null, null, 0, null, -1, null, -1, 3, 4]
    actions = {"LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"};
    data = {{2}, {1, 0}, {2, 2}, {1}, {3, 3}, {2}, {4, 4}, {1}, {3}, {4}};

    int capacity = data[0][0];
    LRUCache lru(capacity);
    std::vector<std::string> output = {"null"};
    for (int i = 1; i < actions.size(); i++)
    {
        if ("put" == actions[i])
        {
            lru.put(data[i][0], data[i][1]);
            output.push_back("null");
        }
        else if ("get" == actions[i])
        {
            int cur_val = lru.get(data[i][0]);
            output.push_back(std::to_string(cur_val));
        }
    }

    std::string output_str = "";
    for (const auto &ele : output)
    {
        output_str += ele + ", ";
    }
    std::cout << '[' << output_str.substr(0, output_str.size() - 2) << "]\n";

    return 0;
}
