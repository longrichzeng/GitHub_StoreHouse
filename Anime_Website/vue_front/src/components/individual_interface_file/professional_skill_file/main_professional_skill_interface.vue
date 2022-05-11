<template>
    <div>
        <el-row style="position: absolute; margin-top: -3.5%;">
            <el-col :span="6">
                <el-button id="delete_button_style" class="el-icon-delete" type="primary" @click="sureDeleteTableData(1)">删除表一</el-button>
            </el-col>
            <el-col :span="6">
                <el-button id="delete_button_style" class="el-icon-delete" type="danger" @click="sureDeleteTableData(2)">删除表二</el-button>
            </el-col>
            <el-col :span="6">
                <el-button id="delete_button_style" class="el-icon-delete" type="success" @click="sureDeleteTableData(3)">删除表三</el-button>
            </el-col>
            <el-col :span="6">
                <el-button id="delete_button_style" class="el-icon-delete" type="warning" @click="sureDeleteTableData(4)">删除表四</el-button>
            </el-col>
        </el-row>
        <div>
            <el-row>
                <el-col :span="12">
                    <v-firstProfessionalSkillTable></v-firstProfessionalSkillTable>
                </el-col>
                <el-col :span="12">
                    <v-secondProfessionalSkillTable></v-secondProfessionalSkillTable>
                </el-col>
                <el-col :span="12">
                    <v-thirtProfessionalSkillTable></v-thirtProfessionalSkillTable>
                </el-col>
                <el-col :span="12">
                    <v-fourthProfessionalSkillTable></v-fourthProfessionalSkillTable>
                </el-col>
            </el-row>
        </div>
    </div>
</template>

<script>
import firstProfessionalSkillTable from "../professional_skill_file/first_professional_skill_table.vue"
import secondProfessionalSkillTable from "../professional_skill_file/second_professional_skill_table.vue"
import thirtProfessionalSkillTable from "../professional_skill_file/thirt_professional_skill_table.vue"
import fourthProfessionalSkillTable from "../professional_skill_file/fourth_professional_skill_table.vue"
import VueCookies from 'vue-cookies';
import {Base64} from 'js-base64';
export default({
    inject: ['reload'],
    data(){
        return{

        }
    },
    methods:{
        deleteTableData(location){
            let postData = this.qs.stringify({
                userName: VueCookies.get("username"),
                location: location
            });
            this.axios({
                method: 'post',
                url: '/individual/deleteProfessionalSkillData',
                data: postData,
            }).then(response=>{
                if(response.data.length != 0){
                    this.$message({
                        type: "success",
                        message: "表格数据删除成功!"
                    })
                    this.reload()
                }else{
                    this.$message({
                        type: "error",
                        message: "表格数据删除失败!"
                    })
                }
            }).catch(error=>{
                console.log(error)
            })
        },
        judgeTableData(location){
            let postData = this.qs.stringify({
                userName: VueCookies.get("username"),
                location: location
            });
            this.axios({
                method: 'post',
                url: '/individual/getProfessionalSkillData',
                data: postData,
            }).then(response=>{            
                if(response.data.length != 0){
                    this.deleteTableData(location)
                }else{
                    this.$message({
                        type: "warning",
                        message: "表格数据为空，无法删除操作!"
                    })
                }
            }).catch(error=>{
                console.log(error)
            })
        },
        sureDeleteTableData(location){
            this.$confirm('确定删除表格数据？', '温馨提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',                    
            }).then(()=>{
                this.judgeTableData(location)
            }).catch(()=>{
                this.$message({
                    type: 'info',
                    message: `提示: ${ "你已取消删除表格数据操作！" }`
                });          
            })
        }
    },
    components:{
        'v-firstProfessionalSkillTable': firstProfessionalSkillTable,
        'v-secondProfessionalSkillTable': secondProfessionalSkillTable,
        'v-thirtProfessionalSkillTable': thirtProfessionalSkillTable,
        'v-fourthProfessionalSkillTable': fourthProfessionalSkillTable,
    },
})
</script>

<style scoped>
#left_navigation_bar{
    background-color: rgba(11, 37, 84, 0.7);
    border-radius: 15px;
    position: fixed;
    top: 25%;
    left: 2%;
    width: 10%;
    height: 25%;
}
#left_toggel{
    font-size: 1.4vw; 
    margin-left: 12%;
    color: aliceblue;
    font-family: STFangsong;
}
#delete_button_style{
    color:aliceblue;
    font-size: 1vw;
    font-weight: 900;
    font-family: STFangsong;
}
</style>