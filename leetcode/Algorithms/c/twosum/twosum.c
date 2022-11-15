/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
#include "../include/uthash.h"
#include <stdio.h>
#include <stdlib.h>

typedef struct map {
    int key;
    int value;
    UT_hash_handle hh;
} map;

map* hashMap = NULL;

static void hashMapAdd(int key, int value) {
    map* s;
    HASH_FIND_INT(hashMap, &key, s);
    if (s == NULL) {
        s = (map*)malloc(sizeof(map));
        s->key = key;
        HASH_ADD_INT(hashMap, key, s);
    }
    s->value = value;
}

static map* hashMapFind(int key) {
    map* s;
    HASH_FIND_INT(hashMap, &key, s);
    return s;
}

static void hashMapCleanup(){
     map* cur, *tmp;
     HASH_ITER(hh, hashMap, cur, tmp){
         HASH_DEL(hashMap, cur);
         free(cur);
     }
 }

static void hashPrint(){
     map* s;
     for(s = hashMap; s != NULL; s=(map*)(s -> hh.next)){
         printf("key %d, value %d\n", s -> key, s -> value);
     }
 }


int* twoSum(int* nums, int numsSize, int target, int* returnSize){

    int i, *ans;
    // hash find result
    map* hashMapRes; 
    hashMap = NULL;
    ans = malloc(sizeof(int) * 2);

    for(i = 0; i < numsSize; i++){
        // key 代表 nums[i] 的值，value 代表所在 index;
        hashMapAdd(nums[i], i);
    }

    hashPrint();

    for(i = 0; i < numsSize; i++){
        hashMapRes = hashMapFind(target - nums[i]);
        if(hashMapRes && hashMapRes -> value != i){
            ans[0] = i;
            ans[1] = hashMapRes -> value ;
            *returnSize = 2;
            return ans;
        }
    }
    
    hashMapCleanup();
    return NULL;
}

int* twoSum1(int* nums, int numsSize, int target, int* returnSize){
    int i, j;
    int* ans = malloc(sizeof(int) * 2);
    for (i = 0; i < numsSize - 1; i++) {
        for (j = i + 1; j < numsSize; j++) {
            if (nums[i] + nums[j] == target)
            {
                ans[0] = i;
                ans[1] = j;
                *returnSize = 2;
                return ans;
            }
        }
    }

    returnSize = 0;
    return NULL;
}

int main() {
    return 0;
}