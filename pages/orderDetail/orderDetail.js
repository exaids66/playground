// pages/orderDetail/orderDetail.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
      details:[
        {
          question:"预约场地",
          answer:""
        },{
          question:"预约时间",
          answer:""
        },{
          question:"联系电话",
          answer:""
        },{
          question:"使用人数",
          answer:""
        }
      ]
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

    },
    
    
})
wx.request({
  url: 'http://121.43.40.44:8080/user/login',
  header: {
    'content-type': 'application/json' // 默认值
  },
  data: {
    x: '',
    y: ''
  },
})