<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Flight Booking Confirmation</title>
</head>
<body>
<p><strong>From:</strong> FASTAYS &lt;pallunimbal009@gmail.com&gt;</p>
    <p><strong>Date:</strong> ${currentDateTime}</p>
    <p><strong>Subject:</strong> Web Booking eTicket (${bookingReference}) - (${passengerName})</p>
    <p><strong>To:</strong> &lt;${passengerEmail}&gt;</p>

    <p>Dear ${passengerName},</p>

    <p>Thank you for using our online booking service.</p>
    <p>Please find attached your electronic ticket receipt. You would need to carry a printout of the e-ticket receipt along with a valid photo identification to gain entry to the airport.</p>
    <p>Kindly ensure that all documents required for your travel are in order. Incomplete/inadequate documents may lead to denied entry into the airport and/or denied boarding. Please note, that Fastays will not be liable for incomplete documentation.</p>

    <p>If you have selected GST during the booking flow, please log on to the website <a href="https://www.fastays.com">www.fastays.com</a> to update your GST details under Manage Booking tab, which can be done only within 48 hours of booking creation.</p>

    <p>Queries or feedback can be given on <a href="https://www.fastays.com/in/en/customer-support.html">Customer Support</a></p>

    <p>We look forward to welcoming you on board and thank you for choosing Fastays!</p>

    <p>Best Regards,<br>Team Fastays</p>

    <p>Please log on to the website <a href="https://www.fastays.com">www.fastays.com</a> to manage your booking.</p>

    <p><strong>CONFIDENTIALITY / DISCLAIMER NOTICE:</strong> The information in this e-mail is confidential and may be legally privileged. It is intended solely for the addressee. If you are not the intended recipient and have received this communication in error, please notify the sender immediately by return e-mail, delete the e-mail and destroy any copies of it. Fastays allows reasonable personal use of the e-mail system. Views and opinions expressed in these communications do not necessarily represent those of Fastays.</p>
</body>
</html>
Invoice Template (invoice-template.ftl)
html
Copy code
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Invoice - Flight Booking</title>
    <style>
        body { font-family: Arial, sans-serif; }
        .invoice-box { max-width: 800px; margin: auto; padding: 20px; border: 1px solid #eee; }
        .heading { font-size: 18px; }
        .content { margin-top: 20px; }
        .item { margin-bottom: 10px; }
    </style>
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