 // Copyright (c) 2012 The Chromium Authors. All rights reserved.
  // Use of this source code is governed by a BSD-style license that can be
  // found in the LICENSE file.
showPhotos();
  function showPhotos() {
    var photos = ["http://c.hiphotos.baidu.com/image/pic/item/83025aafa40f4bfbc9c817b9074f78f0f63618c6.jpg",
    "http://g.hiphotos.baidu.com/image/h%3D200/sign=a622e6cfd02a28345ca6310b6bb4c92e/91ef76c6a7efce1b5b6d3e18ab51f3deb58f659a.jpg",
    "http://a.hiphotos.baidu.com/image/pic/item/e7cd7b899e510fb3a78c787fdd33c895d0430c44.jpg",
    "http://a.hiphotos.baidu.com/image/pic/item/f9dcd100baa1cd11daf25f19bc12c8fcc3ce2d46.jpg"];

    for (var i = 0, photo; photo = photos[i]; i++) {
    	var content = document.getElementById("content");
      var img = document.createElement("img");
      img.src = photo;
      content.appendChild(img);
    }
  }
