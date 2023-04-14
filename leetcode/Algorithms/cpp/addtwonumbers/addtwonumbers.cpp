/**
 * Definition for singly-linked list.
 * */
 
 struct ListNode {
      int val;
      ListNode *next;
      ListNode() : val(0), next(nullptr) {}
      ListNode(int x) : val(x), next(nullptr) {}
      ListNode(int x, ListNode *next) : val(x), next(next) {}
 };
 
class Solution {
public:
    ListNode* addTwoNumbers1(ListNode* l1, ListNode* l2) {
        ListNode* p1 = l1;
        ListNode* p2 = l2;
        ListNode* head = nullptr;
        ListNode* p = nullptr;

        int carry = 0;

        while (p1 != nullptr || p2 != nullptr)
        {
            int num1 = p1 ? p1->val : 0;
            int num2 = p2 ? p2->val : 0;

            int sum = num1 + num2 + carry;

            if (!head)
            {
                head = p = new ListNode(sum % 10);
            }
            else
            {
                p->next = new ListNode(sum % 10);
                p = p->next;
            }
            carry = sum / 10;

            if (p1 != nullptr)
            {
                p1 = p1 ->next;
            }

            if (p2 != nullptr)
            {
                p2 = p2 ->next;
            }
            
        }
        if (carry > 0)
        {
            p->next = new ListNode(carry);
        }
        
        return head;
        
    }

    ListNode* addTwoNumbers2(ListNode* l1, ListNode* l2) {
        ListNode* head = new ListNode(-1);
        ListNode* curr = head;

        int carry = 0;

        while (l1 || l2 || carry) 
        {
            int n1 = l1 ? l1->val : 0;
            int n2 = l2 ? l2->val : 0;

            ListNode* node = new ListNode((n1 + n2 + carry) % 10);
            curr->next = node;
            curr = curr->next;

            l1 = l1 ? l1->next : nullptr;
            l2 = l2 ? l2->next : nullptr;

            carry = (n1 + n2 + carry) / 10;
        }
        return head->next;
    }
    
};