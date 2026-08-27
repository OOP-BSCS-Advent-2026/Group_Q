START
    // Step 1: Initialize arrays for item details and Scanner
    SET itemNames = ["Doll", "Toy Car", "Puzzle", "Ball"]
    SET itemPrices = [12000.0, 8000.0, 6000.0, 5000.0]
    SET itemQuantities = ARRAY OF INTEGER size 4

    // Step 2: Display the price list using a loop
    PRINT "FUNTIME TOY SHOP"
    FOR i = 0 TO length(itemNames) - 1 DO
        PRINT (i + 1) + ". " + itemNames[i] + " UGX " + itemPrices[i]
    END FOR

    // Step 3: Get quantity input from user for each item
    PRINT "\n ENTER QUANTITIES"
    FOR i = 0 TO length(itemNames) - 1 DO
        PRINT "Enter quantity for " + itemNames[i] + ": "
        READ itemQuantities[i]
    END FOR

    // Step 4: Process items and calculate subtotals
    SET grandTotal = 0.0
    SET subtotals = ARRAY OF DOUBLE size 4
    SET discountNotes = ARRAY OF STRING size 4

    FOR i = 0 TO length(itemNames) - 1 DO
        subtotals[i] = calculateSubtotal(i, itemPrices[i], itemQuantities[i])
        discountNotes[i] = getDiscountNote(i, itemQuantities[i])
        grandTotal = grandTotal + subtotals[i]
    END FOR

    // Step 5: Display the final receipt
    CALL printReceipt(itemNames, itemQuantities, subtotals, discountNotes, grandTotal)
END