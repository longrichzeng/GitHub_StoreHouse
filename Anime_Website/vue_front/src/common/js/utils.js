import qs from "qs";
import axios from 'axios';
function verifyMobileNumber(phoneNumber){
    if(phoneNumber !== ''){
        var reg=/^[1][3,4,5,7,8][0-9]{9}$/;
        if (!reg.test(phoneNumber)) {
            return false;
        } else {
            return true;
        }
    }
}

function verifyEmailNumber(phoneEmail){
    if(phoneEmail !== ''){
        var reg=/^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
        if (!reg.test(phoneEmail)) {
            return false;
        } else {
            return true;
        }
    }
}

function deleteAllUserInfor(username){
    deleteAllAnnualPlanData(username)
    deleteAllExpandSkillsData(username)
    deleteAllPersonalInformationData(username)
    deleteAllProfessionalSkillData(username)
    deleteAllShoppingCartData(username)
    deleteAllUserLoginInforData(username)
}

function deleteAllAnnualPlanData(username){
    let postData = qs.stringify({
        userName: username,
    });
    axios({
        method: 'post',
        url: '/individual/deleteAllAnnualPlanData',
        data: postData,
    }).then(response=>{
    }).catch(error=>{
        console.log(error)
    })
}
function deleteAllExpandSkillsData(username){
    let postData = qs.stringify({
        userName: username,
    });
    axios({
        method: 'post',
        url: '/individual/deleteAllExpandSkillsData',
        data: postData,
    }).then(response=>{
        infor = response.data
    }).catch(error=>{
        console.log(error)
    })
}
function deleteAllPersonalInformationData(username){
    let postData = qs.stringify({
        userName: username,
    });
    axios({
        method: 'post',
        url: '/individual/deleteAllPersonalInformationData',
        data: postData,
    }).then(response=>{
        infor = response.data
    }).catch(error=>{
        console.log(error)
    })
}
function deleteAllProfessionalSkillData(username){
    let postData = qs.stringify({
        userName: username,
    });
    axios({
        method: 'post',
        url: '/individual/deleteAllProfessionalSkillData',
        data: postData,
    }).then(response=>{
        infor = response.data
    }).catch(error=>{
        console.log(error)
    })
}
function deleteAllShoppingCartData(username){
    let postData = qs.stringify({
        jinPinBuyingUser: username,
    });
    axios({
        method: 'post',
        url: '/ShoppingCart/deleteAllShoppingCartData',
        data: postData,
    }).then(response=>{
        infor = response.data
    }).catch(error=>{
        console.log(error)
    })
}
function deleteAllUserLoginInforData(username){
    let postData = qs.stringify({
        userName: username,
    });
    axios({
        method: 'post',
        url: '/login/deleteAllUserLoginInforData',
        data: postData,
    }).then(response=>{
        infor = response.data
    }).catch(error=>{
        console.log(error)
    })
}

export{
    verifyMobileNumber,
    verifyEmailNumber,
    deleteAllUserInfor,
    deleteAllAnnualPlanData,
    deleteAllExpandSkillsData,
    deleteAllPersonalInformationData,
    deleteAllProfessionalSkillData,
    deleteAllShoppingCartData,
    deleteAllUserLoginInforData,
}
