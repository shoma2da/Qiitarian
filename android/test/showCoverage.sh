#!/bin/sh
#テストプロジェクト直下に置いてください

TARGET_PROJECT="../src"

#buildファイルの準備
pushd ${TARGET_PROJECT}
android update project -p .

popd
android update test-project -m ${TARGET_PROJECT} -p .

#カバレッジ表示
pushd ${TARGET_PROJECT}
ant emma debug install

popd
ant emma debug install test

#生成されたファイルを開く
open ./bin/coverage.html

#いらないファイルを削除
rm ant.properties
rm build.xml
rm local.properties
pushd ${TARGET_PROJECT}
rm build.xml
rm local.properties
