int totalNumbers(int* digits, int digitsSize) {
    int single[10] = {}, count = 0;
    for (int i = 0; i < digitsSize; ++i) ++single[digits[i]];
    for (int i = 100; i < 1000; i += 2) {
        int c = i % 10;
        if (single[c]-- >= 1) {
            int a = i / 10;
            int b = a % 10;
            if (single[b]-- >= 1) {
                a /= 10;
                count += single[a] >= 1;
            }
            ++single[b];
        }
        ++single[c];
    }
    return count;
}