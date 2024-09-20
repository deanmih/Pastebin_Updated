let lastId = 0;

async function initializeLastId() {
    try {
        const response = await axios.get('/api/lastId');
        lastId = response.data || 0;
        console.log('Initialized Last ID:', lastId);
    } catch (error) {
        console.error('Error fetching last ID:', error);
        lastId = 0;
    }
}

initializeLastId();

async function addBtn() {
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
        lastId += 1;
        btn.id = lastId; 
        btn.addEventListener("click", function() {
            const id = this.id;  
            openTextInNewTab(id); 
        });
        body.appendChild(btn);
    }
}

async function openTextInNewTab(id) {
    try {
        const response = await axios.get(`/api/getTextById/${id}`);
        const text = response.data;
        if (!text) {
            throw new Error("No text found for this ID");
        }
        let newWindow = window.open();
        newWindow.document.write(`
            <!DOCTYPE html>
            <html lang="en">
            <style>
                p#text {
                    font-size: 100px;
                    color: black;
                }
                </style>
            <body>
                <p id="text">${text}</p>
            </body>
            </html>
        `);
        newWindow.document.close();
    } catch (error) {
        console.error('Error fetching text for ID:', id, error);
        alert(`Could not fetch text for the specified ID: ${error.message}`);
    }
}