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
      url: '../myInfo/myInfo'
    })
  },
  eavClick() {
    wx.navigateTo({
      url: '../eav/eav'
    })
  },
  discountClick() {
     wx.navigateTo({
      url: '../myYuyue/myYuyue'
    })
  }
})