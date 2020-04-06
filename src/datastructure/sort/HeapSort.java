package datastructure.sort;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {16, 7, 3, 20, 17, 8};

        heapSort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }


    private static void heapSort(int arr[]){
        //创建大顶堆（从第一个非叶子节点从下至上调整结构）
        for (int i = (arr.length-1)/2;i>=0;i--){
            heapAdjust(arr,arr.length,i);
        }

        //调整堆结构+交换堆顶元素与末尾元素
        for (int i = arr.length-1;i>=0;i--){

            //将堆顶元素与堆尾互换
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;

            //重新对堆进行调整
            heapAdjust(arr,i,0);
        }



    }


    /**
     *
     * 调整堆
     * @param arr 待排序数组
     * @param len 待排序尾元素索引
     * @param parent 父节点
     */
    private static void heapAdjust(int[] arr,int len,int parent){
        //父节点
        int tmp = arr[parent];
        //左子节点
        int lchild = 2*parent+1;



        while(lchild<len){
            if (lchild+1<len){
                if (arr[lchild+1]>arr[lchild]){
                    lchild++;
                }
            }


            if (arr[lchild]>tmp){
                //交换父子节点位置
                arr[parent] = arr[lchild];

                //选取下一个左子节点为父节点继续遍历
                parent = lchild;
                lchild = lchild*2+1;


            }else {
                break;
            }
        }
        arr[parent] = tmp;

    }
}
