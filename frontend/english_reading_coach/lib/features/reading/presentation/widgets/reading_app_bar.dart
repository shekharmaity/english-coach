import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

class ReadingAppBar extends StatelessWidget implements PreferredSizeWidget {
  const ReadingAppBar({super.key});

  @override
  Size get preferredSize => const Size.fromHeight(kToolbarHeight);

  @override
  Widget build(BuildContext context) {
    return AppBar(
      leading: IconButton(
        tooltip: 'Back',
        icon: const Icon(Icons.arrow_back),
        onPressed: () {
          if (context.canPop()) {
            context.pop();
          }
        },
      ),
      title: const Text('Reading'),
      actions: [
        IconButton(
          tooltip: 'Reading settings',
          icon: const Icon(Icons.tune),
          onPressed: () {},
        ),
      ],
    );
  }
}
