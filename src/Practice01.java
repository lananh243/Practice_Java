import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Practice01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số phần tử của mảng : ");
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        do {
            System.out.println("************************MENU**************************");
            System.out.println("1. Nhập giá trị n phần tử của mảng (n nhập từ bàn phím)");
            System.out.println("2. In giá trị các phần tử trong mảng");
            System.out.println("3. Tính trung bình các phần tử dương (>0) trong mảng");
            System.out.println("4. In ra vị trí (chỉ số) các phần tử có giá trị bằng k trong mảng (k nhập từ bàn phím)");
            System.out.println("5. Sử dụng thuật toán sắp xếp nổi bọt sắp xếp mảng giảm dần");
            System.out.println("6. Tính số lượng các phần tử là số nguyên tố trong mảng");
            System.out.println("7. Sắp xếp các phần tử");
            System.out.println("8. Nhập giá trị m từ bàn phím, chèn giá trị m vào mảng (sắp xếp giảm dần) đúng vị trí");
            System.out.println("9. Thoát");
            System.out.print("Vui lòng chọn (1 - 9) : ");
            int choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    for (int  i = 0; i < n; i++) {
                        System.out.printf("numbers[%d] = ",i);
                        numbers[i] = scanner.nextInt();
                    }
                    break;
                case 2:
                    System.out.println("Các phần tử trong mảng : ");
                    for (int  i = 0; i < n; i++) {
                        System.out.printf("%d\t", numbers[i]);
                    }
                    System.out.println();
                    break;
                case 3:
                    int count = 0;
                    int sum = 0;
                    for (int  i = 0; i < n; i++) {
                        if(numbers[i] > 0) {
                            sum += numbers[i];
                            count++;
                        }
                    }
                    if (count > 0) {
                        int average = sum / count;
                        System.out.println("Trung bình của các phần tử dương là: " + average);
                    } else {
                        System.out.println("Không có phần tử dương trong mảng.");
                    }

                    break;
                case 4:
                    System.out.print("Nhập k từ bàn phím : ");
                    int k  = scanner.nextInt();
                    for(int  i = 0; i < n; i++) {
                        if(numbers[i] == k) {
                            System.out.printf("Phần tử có giá trị bằng %d xuất hiện tại vị trí %d",k,i);
                        }
                    }
                    System.out.println();
                    break;
                case 5:
                    int temp;
                    for(int  i = 0; i < n - 1; i++) {
                        for(int j = 0; j < n - i - 1; j++) {
                            if (numbers[j] < numbers[j + 1]) {
                                temp = numbers[j];
                                numbers[j] = numbers[j + 1];
                                numbers[j + 1] = temp;
                            }
                        }
                    }
                    System.out.println("Mảng sau khi sắp xếp là : ");
                    for (int num : numbers) {
                        System.out.printf("%d\t", num);
                    }
                    System.out.println();
                    break;
                case 6:
                    int cnt = 0;
                    System.out.println("Số nguyên tố trong mảng là :");
                    for(int  i = 0; i < numbers.length; i++) {
                        boolean isPrime = true;
                        if (numbers[i] < 2) {
                            isPrime = false;
                        }else {
                            for(int j = 2; j <= Math.sqrt(numbers[i]); j++) {
                                if (numbers[i] % j == 0) {
                                    isPrime = false;
                                    break;
                                }
                            }
                        }
                        if (isPrime) {
                            System.out.printf("%d", numbers[i]);
                            cnt++;
                        }
                        System.out.println();
                    }
                    System.out.println("Số lượng các phần tử là số nguyên tố trong mảng : "+cnt);
                    break;
                case 7:
                    ArrayList<Integer> arr1 = new ArrayList<>();
                    ArrayList<Integer> arr2 = new ArrayList<>();
                    ArrayList<Integer> arr3 = new ArrayList<>();
                    for(int  i = 0; i < numbers.length; i++) {
                        if (numbers[i] % 2 == 0 &&  numbers[i] % 3 == 0) {
                            arr1.add(numbers[i]);
                        } else if (numbers[i] % 2 != 0 && numbers[i] % 3 == 0) {
                            arr2.add(numbers[i]);
                        } else {
                            arr3.add(numbers[i]);
                        }
                    }

                    Collections.sort(arr1);
                    Collections.sort(arr2, Collections.reverseOrder());
                    Collections.sort(arr3);

                    ArrayList<Integer> mergedList = new ArrayList<>();

                    mergedList.addAll(arr1);
                    mergedList.addAll(arr3);
                    mergedList.addAll(arr2);

                    System.out.println("Mảng sau khi gộp là: " + mergedList);
                    break;
                case 8:
                    System.out.print("Nhập m bất kì từ bàn phím : ");
                    int m = scanner.nextInt();
                    int[] newArray = new int[n + 1];
                    for (int i = 0; i < n; i++) {
                        newArray[i] = numbers[i];
                    }
                    newArray[n] = m;

                    for (int i = 0; i < newArray.length - 1; i++) {
                        for (int j = 0; j < newArray.length - 1 - i; j++) {
                            if (newArray[j] < newArray[j + 1]) {
                                int tmp = newArray[j];
                                newArray[j] = newArray[j + 1];
                                newArray[j + 1] = tmp;
                            }
                        }
                    }

                    System.out.println("Mảng sau khi chèn và sắp xếp là: ");
                    for (int num : newArray) {
                        System.out.printf("%d\t",num);
                    }
                    System.out.println();
                    break;
                case 9:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn của bạn không hợp lệ . Vui lòng chọn 1 - 9");
            }
        }while (true);
    }
}
