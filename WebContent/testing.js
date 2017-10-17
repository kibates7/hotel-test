
/*var today = new Date().toISOString().split('T')[0];
document.getElementsByName("check_in")[0].setAttribute('min', today);
*/
//function formats phone numbers like 111-111-1111 during input:
var phone = '(555) 666-7777';

// First clean your input
phone = phone.replace(/[^\d]/g, '');
// Check the length of the phone
if(phone.length == 10){
    // Now we can format the phone
    phone = phone.substring(0,3)+'-'+phone.substring(3,6)+'-'+phone.substring(6, 10);
    // Optionally
    //phone = phone.replace(/(\d{3})(\d{3})/, '$1-$2-');
}
else {
    // whatever you want to tell the user
}