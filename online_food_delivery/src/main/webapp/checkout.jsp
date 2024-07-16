<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Checkout</title>
    <link rel="stylesheet" href="checkout.css">
</head>
<body>
    <h2>Checkout</h2>
    <form action="Checkout" method="post">
        <label for="address">Delivery Address:</label>
        <textarea id="address" name="address" required></textarea><br><br>
        
        <label>Payment Method:</label>
        <select name="paymentMethod">
            <option value="creditCard">Credit Card</option>
            <option value="UPI">UPI</option>
            <option value="debitCard">Debit Card</option>
            <option value="cod">Cash on Delivery</option>
        </select><br><br>

        <input type="submit" value="Place Order">
    </form>
</body>
</html>
