TIMEOUT = 15;

count = 0
currentInterval = setInterval(() => {
    $('#counter').text(`${count + 1}`.padStart(2, '0'))
    count += 1

    if (count >= TIMEOUT) {
        clearInterval(currentInterval);
        currentInterval = null;
			
        $('#counter').text("done")
    }
}, 200);
