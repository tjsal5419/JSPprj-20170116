   <script>
   var f = function() {
      
      var regButton = document.querySelector(".reg-button");
      regButton.onclick = function() {
         var form = document.querySelector("#form");
         var formData = new FormData(form);
         var request = new window.XMLHttpRequest();
         var progressBar = document.querySelector("progress");

         request.onprogress = function(event) {
            progressBar.value = parseInt((event.onloaded / event.total)*100);
         };
         //console.log("ss");
         
         request.onload = function() {

         };
         
         request.open("POST", "notice-reg-ajax", true); //비동기식
         request.send(formData);
         
         
         return false;
      };
   };
   f();
   </script>