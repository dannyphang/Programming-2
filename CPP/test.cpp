#include<iostream>
#include<list>
using namespace std;

void test(int num){
    float array[num];
    for(int i = 0; i < num; i++){
        cout << array[i] << endl;
    }
}

void test2(float *array, int num){
    
    int count = 0, num2;
	for (int i = 0; i < num; i++) {
		if (array[i] == NULL) {
			count++;
		}
	}
    num2 = num - count;
    
    cout << num2 << endl;
    
    for(int i = 0; i < num2; i++){
        // if(array[i] != NULL){
            cout << array[i] << endl;
        // }
    }
    
    // "clearing" the array
    for(int i = 0; i < num; i++){
        array[i] = NULL;
    }
    
    // for(int i = 0; i < num; i++){
    //     cout << "-" << array[i] << endl;
    // }
    
}

int main(){
    int num = 12;
    
    float array[num];
    
    // list<float> li; // arraylist
    
    for(int i = 0; i < num; i++){
        array[i] = NULL;
    }
    
    array[0] = 400;
    array[1] = 450;
    array[2] = 500;
    
    test2(array, num);
    
    // li.push_back(3.142);
    // li.push_back(2.142);
    
    // list <float> :: iterator it;
    
    // int i;
    // for(it = li.begin(), i = 0; it != li.end(); it++, i++){
        
        
        
    //     cout << *it << endl;
        
    // }
    
    // test(li.size());
    
    // //cout << li.back() << endl;
    
    
    
    system("Pause");
    return 0;
}