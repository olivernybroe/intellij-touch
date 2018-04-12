package dk.lost_world.intellij_touch.Components;

import com.intellij.openapi.actionSystem.AnAction;

public class CandidateListBuilder extends ComponentBuilder<CandidateListBuilder> {

    public CandidateListBuilder() {
    }

    @Override
    public CandidateListBuilder fromAnAction(AnAction action) {

        return this;
    }


    @Override
    public void add() {

    }
}
