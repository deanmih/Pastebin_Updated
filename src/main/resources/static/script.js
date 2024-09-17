function addBtn() {
    let body = document.getElementById("mainbody");
    let btn = document.createElement("button");
    let inpt = document.getElementById("inputbox").value;
    btn.innerHTML = inpt;
    btn.value = inpt;
    btn.className = "btn";

    if (inpt.trim() !== "") {
        if (inpt.length > 10) {
            btn.innerHTML = inpt.substr(0, 10) + "...";
        }
        btn.addEventListener("click", function() {
            const value = this.value;
            axios.post('/checkValue', value, {
                headers: {
                    'Content-Type': 'text/plain' 
                }
            })
            .then(response => {
                if (response.data) {
                    const newTab = window.open('', '_blank');  
                    newTab.document.write(`
                        <html>
                        <head><title>Button Text</title></head>
                        <body>
                            <h1>${value}</h1>
                        </body>
                        </html>
                    `);
                    newTab.document.close();
                }
            })
            .catch(error => {
                console.error('Error:', error); 
            });
        });
        body.appendChild(btn);
    }
}