var app=getApp();
var util = require('../../utils/util.js')

Page({
  data: {
    userInfo: null
  },

  onLoad: function () {
    var userInfo = app.globalData.userInfo;
    if (userInfo) {
      this.setData({
        userInfo: userInfo
      })
    }
  },

  yuyueClick() {
    wx.navigateTo({
      url: '../repair/repair'
    })
  },

  myInfoClick() {
    wx.navigateTo({
      url: '/pages/login/login'
    })
  },
  toLogin() {
    wx.navigateTo({
      url: '/pages/login/login'
    })
  },
  eavClick() {
    wx.navigateTo({
      url: '../eav/eav'
    })
  },
  discountClick() {
     wx.navigateTo({
      url: '/pages/orderRecord/orderRecord'
    })
  }
})