
## 使用ItemTouchHelper，实现拖拽和侧滑删除

#### 什么是ItemTouchHelper


  > This is a utility class to add swipe to dismiss and drag & drop support to RecyclerView.It works with a RecyclerView and a Callback class, which configures what type of interactions are enabled and also receives events when user performs these actions.Depending on which functionality you support, you should override onMove(RecyclerView, ViewHolder, ViewHolder) and / or onSwiped(ViewHolder, int).

  
  以上是官方文档的介绍，ItemTouchHelper是一个工具类，可实现侧滑删除和拖拽移动，使用这个工具类需要RecyclerView和Callback。同时根据需要重写onMove和onSwiped方法。
  
  此deme使用ItemTouchHelper简单实现侧滑删除和拖拽功能。
