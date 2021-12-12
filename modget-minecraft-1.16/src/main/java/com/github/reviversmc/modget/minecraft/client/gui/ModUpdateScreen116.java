package com.github.reviversmc.modget.minecraft.client.gui;

import com.github.reviversmc.modget.minecraft.Modget;
import com.github.reviversmc.modget.minecraft.client.gui.widgets.ModUpdateListWidget;
import com.github.reviversmc.modget.minecraft.manager.ModgetManager;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ScreenTexts;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Util;

@Environment(EnvType.CLIENT)
public class ModUpdateScreen116 extends ModUpdateScreenBase {

    public ModUpdateScreen116(Screen parent) {
        super(parent);
    }


    @Override
    ModUpdateListWidget<?> setUpdateListWidget() {
        return new ModUpdateListWidget<ModUpdateScreen116>(client, this);
    }

    @Override
    void addUpdateListWidget() {
        addChild(updateListWidget);
    }


    @Override
    ButtonWidget addRefreshButton() {
        return addButton(new ButtonWidget(refreshX, actionRowY, buttonWidth, buttonHeight, new TranslatableText("gui." + Modget.NAMESPACE + ".refresh"), buttonWidget -> ModgetManager.UPDATE_MANAGER.searchForUpdates()));
    }

    @Override
    ButtonWidget addDownloadButton() {
        return addButton(new ButtonWidget(downloadX, actionRowY, buttonWidth, buttonHeight, new TranslatableText("gui." + Modget.NAMESPACE + ".download"), buttonWidget -> {
            if (updateListWidget.getSelected() != null) {
                Util.getOperatingSystem().open(updateListWidget.getSelected().getUpdate().getDownloadPageUrls().getModrinth());
            }
        }));
    }

    @Override
    ButtonWidget addDoneButton() {
        return addButton(new ButtonWidget(doneX, doneY, buttonWidth, buttonHeight, ScreenTexts.DONE, buttonWidget -> {
            assert client != null;
            client.openScreen(parent);
        }));
    }

}
