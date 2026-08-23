    int diff = 0;
    int leftQ = 0;
    int rightQ = 0;

    // First half
    for (int i = 0; i < half; i++) {
        if (num.charAt(i) == '?') {
            leftQ++;
        } else {
            diff += num.charAt(i) - '0';
        }
    }

    // Second half
    for (int i = half; i < n; i++) {
        if (num.charAt(i) == '?') {
            rightQ++;
        } else {
            diff -= num.charAt(i) - '0';
        }
    }

    // Equal number of '?' -> Bob can always balance
    if (leftQ == rightQ) {
        return false;
    }

    // Bob wins only if the difference can be exactly balanced
    return 2 * Math.abs(diff) != 9 * Math.abs(leftQ - rightQ);
}