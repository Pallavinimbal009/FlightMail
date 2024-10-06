<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Booking Confirmation</title>
</head>
<body>
<div class="invoice-box">
        <h2 class="heading">Flight Booking Invoice</h2>

        <p class="item"><strong>Booking Reference:</strong> ${bookingReference}</p>
        <p class="item"><strong>Passenger Name:</strong> ${passengerName}</p>
        <p class="item"><strong>Flight Number:</strong> ${flightNumber}</p>
        <p class="item"><strong>Departure:</strong> ${departureAirport} (${departureTime})</p>
        <p class="item"><strong>Arrival:</strong> ${arrivalAirport} (${arrivalTime})</p>
        <p class="item"><strong>Price:</strong> $${price}</p>

        <div class="content">
            <p>Thank you for booking your flight with Fastays. Please keep this invoice for your records.</p>
        </div>

        <p>For any queries or issues, please contact our support at <a href="https://www.fastays.com/in/en/customer-support.html">Customer Support</a>.</p>
    </div>
</body>
</html>