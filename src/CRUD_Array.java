import java.util.Scanner;

public class CRUD_Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];
        int size = 0;

        while (true) {
            System.out.println("\nChọn thao tác:");
            System.out.println("1. Thêm phần tử");
            System.out.println("2. Hiển thị mảng");
            System.out.println("3. Cập nhật phần tử");
            System.out.println("4. Xóa phần tử");
            System.out.println("5. Thoát");
            System.out.print("Nhập lựa chọn: ");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Nhập số lượng phần tử cần thêm: ");
                    int numToAdd = scanner.nextInt();

                    if (size + numToAdd > array.length) {
                        System.out.println("Không đủ chỗ trống trong mảng! Chỉ có thể thêm tối đa " + (array.length - size) + " phần tử.");
                    } else {
                        System.out.println("Nhập các phần tử:");
                        for (int i = 0; i < numToAdd; i++) {
                            System.out.print("Arr[" + (size + i) + "] = ");
                            array[size + i] = scanner.nextInt();
                        }
                        size += numToAdd;
                        System.out.println("Đã thêm thành công " + numToAdd + " phần tử.");
                    }
                    break;
                case 2:
                    System.out.print("Các phần tử trong mảng là : ");
                    if (size == 0) {
                        System.out.println("{}");
                    } else {
                        for (int i = 0; i < size; i++) {
                            System.out.print(array[i]);
                            if (i < size - 1) {
                                System.out.print(", ");
                            }
                        }
                    }
                    break;

                case 3:
                    System.out.print("Nhập vị trí cần cập nhật (0 đến " + (size - 1) + "): ");
                    int index = scanner.nextInt();
                    if (index >= 0 && index < size) {
                        System.out.print("Nhập giá trị mới: ");
                        array[index] = scanner.nextInt();
                        System.out.println("Cập nhật thành công.");
                    } else {
                        System.out.println("Vị trí không hợp lệ!");
                    }
                    break;

                case 4:
                    System.out.print("Nhập vị trí cần xóa (0 đến " + (size - 1) + "): ");
                    int deleteIndex = scanner.nextInt();
                    if (deleteIndex >= 0 && deleteIndex < size) {
                        for (int i = deleteIndex; i < size - 1; i++) {
                            array[i] = array[i + 1];
                        }
                        size--;
                        System.out.println("Xóa thành công.");
                    } else {
                        System.out.println("Vị trí không hợp lệ!");
                    }
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập lại.");
                    break;
            }
        }
    }
}

