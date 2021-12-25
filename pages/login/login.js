Page({
    /**
     * 页面的初始数据
     */
    data: {
        phone:'',
        password:''
    },
    handleInput(event){
        // console.log();
        let type = event.currentTarget.id;
        console.log(type,event.detail.value);
        this.setData({
            [type]:event.detail.value
        })
    },
    async onClickSubmit(){
        // 获取类型
        let {phone,password} = this.data;
        if(!phone){
            wx.showToast({
              title: '手机号不能为空！',
              icon: "none",
            })
            return;
        }
        // 定义正则表达式
        let phoneReg = /^1(3|4|5|6|7|8|9)\d{7}$/;
        if(!phoneReg.test(phone)){
            wx.showToast({
              title: '手机号格式错误！',
              icon: "none"
            })
            return;
        }
        if(!password){
             wx.showToast({
              title: '密码不能为空！',
              icon: "none"
            })
            return;
        }
        // console.log(phone);
       let result = wx.request({
           
        url: 'http://121.43.40.44:8080/user/login',
        data: {
            // "phone":phone,
            // "password": password
            phone:phone,
            password: password
        }, header: {
            'content-type': 'application/x-www-form-urlencoded;charset=UTF-8'
        },
        method:"POST",
        success:function(res){
            console.log(phone);
            console.log(res.data);
            if(res.data.code === -1){
                wx.showToast({
                title: '用户名或密码错误！',
                icon:"none"
              })
            }else{
                wx.showToast({
                title: '登录成功！'
                }),
                wx.switchTab({
                  url: '/pages/user/user',
                })
            }          
        },
        fail:function(res){
            console.log(res.data);
        }
       })
       console.log("aa",result);
        
    },
    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {

    },

    /**
     * 生命周期函数--监听页面初次渲染完成
     */
    onReady: function () {

    },

    /**
     * 生命周期函数--监听页面显示
     */
    onShow: function () {

    },

    /**
     * 生命周期函数--监听页面隐藏
     */
    onHide: function () {

    },

    /**
     * 生命周期函数--监听页面卸载
     */
    onUnload: function () {

    },

    /**
     * 页面相关事件处理函数--监听用户下拉动作
     */
    onPullDownRefresh: function () {

    },

    /**
     * 页面上拉触底事件的处理函数
     */
    onReachBottom: function () {

    },

    /**
     * 用户点击右上角分享
     */
    onShareAppMessage: function () {

    }
})